from fastapi import FastAPI
from database import SessionLocal, Base, engine
from models.customer import Customer, CustomerSerial

app = FastAPI()

#Base.metadata.create_all(engine)

db=SessionLocal()


@app.get("/customers")
def get_customers():
    customers = db.query(Customer).all()
    return customers

@app.post("/customers")
def insert_customer(cs:CustomerSerial):
    c=Customer(name=cs.name, firstname=cs.firstname, imsi=cs.imsi, 
               birthdate=cs.birthdate, msisdn=cs.msisdn)
    db.add(c)
    db.commit()