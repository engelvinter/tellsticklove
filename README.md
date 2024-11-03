# Tellstick Love

Tellstick Love is a yocto image for the Raspberry 3 model B and the Tellstick Duo (which is a 433 Mhz control unit from the former company Telldus).
It is built around the telldus daemon (telldusd) to control the Tellstick Duo, the mosquitto MQTT broker and home assistant as container, all running on a Rasberry 3.


First create a virtual python environment:
> python -m venv venv
> pip install -r requirements.txt

Build the yocto image using kas:
> kas build config.yml

Flash the yocto image to your 32 GB SD Card. Right now it is configured for this size.

Login into the device using ssh:
> ssh root@192.168.X.YYY

Edit the tellstick.conf file and add your switches and temperature sensors:
> vi /etc/tellstick.conf

Create the Home Assistant container:
> home-assistant.sh create

Wait for quite a while....

Once finished:
> reboot

Log into home-assistant:
* Set login and password
* Set city
* set date & time format in profile
* Add MQTT integration. Use <ip-number> as broker since Mosquitto already running.
* Verify that the devices are discovered
* Create a label for the  switches
* Create four automations: EveningTurnOn, EveningTurnOff, MorningTurnOn, MorningTurnOff
