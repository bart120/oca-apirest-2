from sqlalchemy import create_engine
from sqlalchemy.orm import declarative_base, sessionmaker

engine = create_engine("postgresql://formation:formation@localhost/formation", 
                       echo=True)
Base=declarative_base()

SessionLocal=sessionmaker(bind=engine)