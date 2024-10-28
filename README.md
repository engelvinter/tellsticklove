# Tellstick Love

Tellstick Love is a yocto image for the Raspberry 3 model B and the Tellstick Duo (which is a 433 Mhz control unit from the former company Telldus).

First create a virtual python environment:
> python -m venv venv
> pip install -r requirements.txt

Build the yocto image using kas:
> kas build config.yml

Flash the yocto image to your 32 GB SD Card. Right now it is configured for this size.

Login into the device using ssh:
> ssh root@192.168.X.YYY

Create the Home Assistant container:
> home-assistant.sh create

Wait for quite a while....

Once finished:
> reboot

