import LLMTaskAgent
from google.adk.memory import SimpleMemory

from AIAgent.MIPInvoker import MIPInvoker
from AIAgent.OllamaLLM import OllamaLLM
from AIAgent.Prompts import description_1, prompt_1

tool = MIPInvoker()

ollama_llm = OllamaLLM(model="mistral")

AGENT = LLMTaskAgent(
    name="Invoker",
    description= description_1,
    tools=[tool],
    llm = ollama_llm,
    memory = SimpleMemory(),
    instruction = prompt_1
)