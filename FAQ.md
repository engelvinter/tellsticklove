**How to temporarily turn off login/password for the dropbear ssh daemon?**  
In the file /etc/default/dropbear, insert **-B** in as extra args

**Where is the config of telldus?**  
Check /etc/tellstick.conf

**How to detect events from a device?**
> tellcore_events --all --raw

**I have changed /etc/tellstick.conf. How to make telldusd restart?**
> systemctl restart telldusd

**How to turn on a 433 Mhz device using tellstick?**
> tdtool --on telldus_id

**How to learn a 433 Mhz device its id using tellstick?**
> tdtool -learn telldus_id

**How to verify that MQTT devices have been registered in the Mosquitto MQTT broker?**  
This command will subscribe for all events for all devices in the MQTT broker:
> mosquitto_sub -h localhost -t "#" -v

**How to turn on a 433 Mhz device using mosquitto?**  
> mosquitto_pub -t telldus/telldus_id/switch/set -m 1

**How to turn off a 433 MHz device using mosquitto?**  
> mosquitto_pub -t telldus/telldus_id/switch/set -m 2

**How to restart the telldus-core mqtt service?**  
> systemctl restart telldus-core-mqtt

**How to view the log for telldus-core-mqtt?**  
> journalctl -u telldus-core-mqtt

**How to copy a 32 GB SD-card to your local harddrive?**  
> lsblk  
> sudo dd if=/dev/mmcblk0 of=your_path/your_name.img bs=4M status=progress

**How to copy an image from your local harddrive to a 32 GB SD-card?**  
> cd <tellsticklove_src_dir>  
> sudo ./flash.sh

**Which SD-card to buy?**  
Look for SD cards named as high endurance e.g. Samsung Pro Endurance

**How to connect to the serial port on a raspberry? (Ubuntu 22.04)**  
> sudo putty -serial /dev/ttyUSB0 -sercfg 115200

**Where is the config files and database of home-assistant?**  
See /usr/share/home-assistant

