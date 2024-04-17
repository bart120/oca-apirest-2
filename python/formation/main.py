from fastapi import FastAPI, Response
from database import SessionLocal, Base, engine
from models.customer import Customer, CustomerSerial

app = FastAPI()

#Base.metadata.create_all(engine)

db=SessionLocal()


@app.get("/customers")
def get_customers():
    customers = db.query(Customer).all()
    return customers

@app.get("/customers/{msisdn}")
def get_customer_by_msisdn(msisdn:str):
    try:
        c = db.query(Customer).filter(Customer.msisdn == msisdn).one_or_none()
        if c is not None:
            return c
        else:
            return Response(status_code=404, content=None)
    except:
        return Response(status_code=400, content="Many customers with msisdn")

@app.post("/customers", status_code=201)
def insert_customer(cs:CustomerSerial):
    c=Customer(name=cs.name, firstname=cs.firstname, imsi=cs.imsi, 
               birthdate=cs.birthdate, msisdn=cs.msisdn)
    db.add(c)
    db.commit()
    cs.id = c.id
    return cs