# Base this image on rpi test image
include recipes-core/images/rpi-test-image.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " dropbear libconfuse libftdi ftdi-modprobe telldus-core telldus-daemon telldus-core-mqtt"
IMAGE_FEATURES += " ssh-server-dropbear"