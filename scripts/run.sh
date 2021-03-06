#!/usr/bin/env bash

set -u

DOCKER=$(which docker)
CAT=$(which cat)

"${DOCKER}" run --name "thoughtworks-java-test" \
                --detach \
                "thoughtworks:1.0.0"


if [ $? -eq 0 ]; then

  set -e

  # get Docker container IP address
  readonly DOCKER_CONTAINER_IP=$( \
    "${DOCKER}" inspect \
                --format \
                  "{{ .NetworkSettings.Networks.bridge.IPAddress }}" \
                --type \
                  container \
                "thoughtworks-java-test" \
                )

  "${CAT}" << EOM

  ------------------------------------------------------------------------------
  -- Docker run
  Docker running on ip: ${DOCKER_CONTAINER_IP}
  ------------------------------------------------------------------------------

EOM

else

  set -e

  "${CAT}" << EOM

  ------------------------------------------------------------------------------
  -- Docker run

  There is a container already running.
  ------------------------------------------------------------------------------

EOM

fi

exec "$@"
