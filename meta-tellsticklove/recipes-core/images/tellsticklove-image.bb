# Base this image on rpi test image
include recipes-core/images/rpi-test-image.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " dropbear libconfuse libftdi ftdi-modprobe"
IMAGE_FEATURES += " ssh-server-dropbear"