from fastapi import FastAPI, Response
from database import SessionLocal, Base, engine
from models.customer import Customer, CustomerSerial
from models.device import Device, DeviceSerial
from routers import customers_router, devices_router

app = FastAPI()

Base.metadata.create_all(engine)


app.include_router(customers_router.router)
app.include_router(devices_router.router)



