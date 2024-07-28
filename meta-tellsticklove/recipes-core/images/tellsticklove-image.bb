# Base this image on rpi test image
include recipes-core/images/rpi-test-image.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL:append = " dropbear"
IMAGE_FEATURES:appen = " ssh-server-dropbear"