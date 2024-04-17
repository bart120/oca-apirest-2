from database import Base
from pydantic import BaseModel
from datetime import datetime
from sqlalchemy import Column, Integer, String, DateTime

class Customer(Base):
    __tablename__ = 'customers_python'
    id = Column(Integer, primary_key=True)
    msisdn = Column(String(15), nullable=False)
    name = Column("lastname", String(50))
    firstname = Column(String(50))
    imsi = Column(String(15))
    birthdate= Column(DateTime)

class CustomerSerial(BaseModel):
    id:int=0
    name:str
    firstname:str
    msisdn:str
    imsi:str
    birthdate:datetime

