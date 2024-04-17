from fastapi import Response, APIRouter
from database import SessionLocal, Base, engine
from models.customer import Customer, CustomerSerial
from models.device import Device, DeviceSerial

router = APIRouter()
db=SessionLocal()

@router.get("/devices")
def get_devices(customerid:int):
    if customerid is not None:
        devices = db.query(Device).filter(Device.customer_id == customerid).all()
        return devices
    else:
        devices = db.query(Device).all()
        return devices
    
@router.post("/devices", status_code=201)
def insert_device(ds:DeviceSerial):
    d=Device(label=ds.label, imei=ds.imei)
    db.add(d)
    db.commit()
    ds.id = d.id
    return ds