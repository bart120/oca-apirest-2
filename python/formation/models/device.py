from database import Base
from pydantic import BaseModel
from sqlalchemy import Column, Integer, String, ForeignKey
from models.customer import Customer, CustomerSerial

class Device(Base):
    __tablename__ = 'devices_python'
    id = Column(Integer, primary_key=True)
    imei = Column(String(15), nullable=False)
    label = Column(String(50))
    customer_id = Column(Integer, ForeignKey("customers_python.id"), nullable=False)
    #customer: relationship("Customer", back_populates="devices")

class DeviceSerial(BaseModel):
    id:int=0
    imei:str
    label:str
    customer_id:int