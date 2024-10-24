#!/bin/sh

# Check if argument is provided
if [ -z "$1" ]; then
  echo "No argument provided. Please specify 'start' or 'stop'."
  exit 1
fi

DOCKER_COMPOSE=/usr/lib/docker/cli-plugins/docker-compose
YAML_FILE=/etc/docker/compose/home-assistant.yml

# Check the argument value
if [ "$1" = "start" ]; then

  echo "Starting home-assistant..."
  ha=$(/usr/bin/docker images -q homeassistant/home-assistant:latest)
  if [ -n "$ha" ]; then 
    $DOCKER_COMPOSE -f $YAML_FILE up
  else
    echo "Failed starting home-assistant - no image has been created"
  fi

elif [ "$1" = "stop" ]; then

  echo "Stopping home-assistant..."
  $DOCKER_COMPOSE -f $YAML_FILE down

else

  echo "Invalid argument. Please use 'start' or 'stop'."
  exit 1

fi
