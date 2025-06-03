# Open Source GenAI with InstructLab and Granite



### Creating by API
```bash
curl -X POST -H 'Content-Type: application/json' \
-H 'Authorization: Bearer '$DIGITAL_OCEAN_TOKEN'' \
-d '{"name":"granite-instructlab-droplet",
        "size":"s-8vcpu-32gb-amd",
        "region":"nyc1",
        "image":"fedora-41-x64",
        "vpc_uuid":"'$VPC_UUID'",
        "tags":["genai"]}' \
"https://api.digitalocean.com/v2/droplets"
```

### Creating by doctl
```bash
doctl compute droplet create \
--image fedora-41-x64 \
--size s-8vcpu-32gb-amd \
--region nyc1 \
--vpc-uuid $VPC_UUID \
--tag-names 'genai' \
granite-instructlab-droplet
```



## Setup for ilab
```bash
# 1) Inside the Fedora VM (tested on Fedora 40 Workstation)
sudo dnf upgrade -y

# 2) Core development tools + Python 3.11
sudo dnf install -y gcc gcc-c++ make git-core \
python3.11 python3.11-devel

# Optional: CUDA & friends for NVIDIA GPUs
# (Replace 12-4 with the current runtime version)
# :contentReference[oaicite:9]{index=9}
sudo dnf install -y cuda-toolkit-12-4 \
libcudnn8 libcudnn8-devel \
libnccl libnccl-devel      


# 3) Create a working directory and Python virtual environment:
mkdir ~/ai && cd ~/ai
python3.11 -m venv venv
source venv/bin/activate

# 5)
# GPU build: pip install --upgrade 'instructlab[cuda] 
# :contentReference[oaicite:10]{index=10}
# drop “[cuda]” if you are CPU-only
pip install --upgrade 'instructlab'        


# 6) 
ilab --version

#
huggingface-cli login


#
ilab config init


#
ilab model download 

#
ilab model serve


#
ilab model download --repository instructlab/granite-7b-lab-GGUF --filename granite-7b-lab-Q4_K_M.gguf --hf-token $HF_TOKEN

```


### inside the (venv)
```bash
 1  ls
    2  curl http://localhost:8080/docs
    3  curl http://localhost:8000/docs
    4  curl http://localhost:8000/v1
    5  cd ia
    6  cd ai/
    7  ls
    8  source venv/bin/activate
    9  ilab model
   10  ilab model dowload -h
   11  ilab model dowload 
   12  ilab model download
   13  ilab model download -h
   14  ilab model download --help
   15  ilab model download --filename granite-code:8b
   16  #ilab model download --filename granite-code:8Db --hf-token 
   17  vim
   18  vi .env
   19  source .env
   20  env
   21  cat .ent
   22  cat .env
   23  ilab model download --filename granite-code:8Db --hf-token $HF_TOKEN
   24  ilab model download --repository instructlab/granite-7b-lab-GGUF --filename granite-7b-lab-Q4_K_M.gguf --hf-token $HF_TOKEN
   25  ilab model list
   26  history
   27  exit
   28  ls
   29  cd ai/
   30  history
   31  source .env
   32  source venv/bin/activate
   33  history
   34  ilab model chat --help
   35  ilab model chat --help | less
   36  ilab model list
   37  ilab model chat --model /root/.cache/instructlab/models/ibm-granite
   38  history

```




## RESOURCES

- [Open Source GenAI with InstructLab and Granite](https://learning.oreilly.com/live-events/open-source-genai-with-instructlab-and-granite/0642572006017/)
- [PDF Slides](https://on24static.akamaized.net/event/48/99/82/9/rt/1/documents/resourceList1747827469081/instructlabv41747827469081.pdf)
- [GitHub: Sander Van - instructlab](https://github.com/sandervanvugt/ilab)
- [Hugging Face](https://huggingface.co)
- [Replicate](https://replicate.com/home)
- [Replicate: ibm-granite/granite-3.3-8b-instruct](https://replicate.com/ibm-granite/granite-3.3-8b-instruct/api/learn-more)
- [Replicate: playground for granite](https://replicate.com/playground?model=ibm-granite/granite-3.3-8b-instruct)
- [InstructLab Project](https://docs.instructlab.ai)
- [GitHub: instructlab](https://github.com/instructlab/instructlab)
- [Granite](https://research.ibm.com/blog/granite-code-models-open-source)
- [IBM watson assistant llm for granite](https://www.ibm.com/docs/en/watsonx/watsonx-code-assistant-4z/2.x?topic=z-granite20bcodecobol-model-card)
- [IBM granite-code-z-xplain model card](https://www.ibm.com/docs/en/watsonx/watsonx-code-assistant-4z/2.x?topic=z-granite-code-xplain-model-card)
- [IBM granite.20b.code.cobol model card](https://www.ibm.com/docs/en/watsonx/watsonx-code-assistant-4z/2.x?topic=z-granite20bcodecobol-model-card)
- [Ollama : Granite-code](https://ollama.com/library/granite-code)


