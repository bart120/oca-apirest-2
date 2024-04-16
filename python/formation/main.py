from fastapi import FastAPI

app = FastAPI()


@app.get("/customers")
def get_customers():
    return []