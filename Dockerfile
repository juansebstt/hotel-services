FROM ubuntu:latest
LABEL authors="under"

ENTRYPOINT ["top", "-b"]