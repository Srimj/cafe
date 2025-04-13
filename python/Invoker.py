import base64

import requests
from google.adk.tools.base import Tool

from AIAgent.JwtToken import JWT_TOKEN


class Invoker(Tool):
    def __init__(self):
        super().__init__(name="Invoker", description="Invoke API")
        self.api_url = "http://localhost:8080/api"
        self.body = {
                "attestedValues": [
                    {
                    }
                ],
                "document": {
                    "mimeType": "application/pdf",
                    "data": ""
                }
        }
        self.headers = {
            "Content-Type": "application/json",
            "Accept": "*/*",
            "Authorization":JWT_TOKEN
        }

    def call(self, input: dict) -> dict:
        file_path = input.get("file_path")
        if not file_path:
            raise {"error": "Missing 'file_path' in input."}
        try:
            with open(file_path, "rb") as file:
                # Convert file content to base64
                encoded_file = base64.b64encode(file.read()).decode("utf-8")
                # Update the request body with the base64-encoded data
                self.body["document"]["data"] = encoded_file

            response = requests.post(self.api_url, headers=self.headers, json=self.body)

            if response.status_code == 200:
                return response.json()
            else:
                return {"error": f"API error: {response.status_code}", "details": {response.text}}
        except Exception as e:
            return {"error": str(e)}