description_1 = """
This agent is responsible for invoking the API to classify documents and return the classification results.
"""


prompt_1 = """
The task of this agent is to take any document, limited to below list of document mime  types, as user input and structure it in the below API request format and invokes the spring application endpoint and provides a pretty-printed response.

The allowed document mime types are:
- application/pdf
- image/jpeg
- image/png
- image/bmp

The API request body format is as follows:
{
    "attestedValues": [
        {
        }
    ],
    "document": {
        "mimeType":"",
        "data": "base64 encoded value of the provided file"
    }
}

"""