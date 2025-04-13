from google.adk.llms.base import LLM

class OllamaLLM(LLM):
    def __int__(self, model="mistral"):
        self.model = model

    def complete(self, prompt: str, **kwargs) -> str:
        import requests
        res = requests.post(
            "http://192.168.0.183:11434/generate",
            json={"model": self.model, "prompt": prompt, "stream": False}
        )
        return  res.json()["response"]