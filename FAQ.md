**How to temporarily turn off login/password for the dropbear ssh daemon?**  
In the file /etc/default/dropbear, insert **-B** in as extra args

**How to verify that MQTT devices have been registered in the Mosquitto MQTT broker?**  
This command will subscribe for all events for all devices in the MQTT broker:
mosquitto_sub -h localhost -t "#" -v

**How to turn on a 433 Mhz device using tellstick?**
> tdtool --on telldus_id

**How to learn a 433 Mhz device its id using tellstick?**
> tdtool -learn telldus_id
