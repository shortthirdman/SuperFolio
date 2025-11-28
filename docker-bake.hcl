group "default" {
  targets = ["backend"]
}

target "common" {
  platforms = ["linux/amd64", "linux/arm64"]
  annotations = ["org.opencontainers.image.authors=shortthirdman"]
  no-cache = true
  labels = {
    "org.opencontainers.image.authors" = "ShortThirdMan",
    "org.opencontainers.image.version" = "1.0",
    "org.opencontainers.image.vendor" = "ShortThirdMan"
    "org.opencontainers.image.source" = "https://github.com/shortthirdman/TransAeroHub"
    "org.opencontainers.image.description" = "Database containing information about countries, airports and airlines"
  }
}

variable "TAG" {
  default = "latest"
}

variable "DOCKER_REGISTRY" {
  default = "docker.local"
}

target "backend" {
  inherits = ["common"]
  context = "."
  dockerfile = "Dockerfile"
  tags = ["${DOCKER_REGISTRY}/shortthirdman/transaerohub:${TAG}"]
}