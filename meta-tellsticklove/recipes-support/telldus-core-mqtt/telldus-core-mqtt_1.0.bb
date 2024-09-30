SUMMARY = "Telldus Core MQTT integration"
DESCRIPTION = "Integration of Telldus Core with MQTT for home automation."
HOMEPAGE = "https://github.com/engelvinter/telldus-core-mqtt"
LICENSE = "CLOSED"

# Source location
SRC_URI = "git://github.com/engelvinter/telldus-core-mqtt.git;branch=master;protocol=https"
SRCREV = "${AUTOREV}"

# Destination directory for the cloned repo
S = "${WORKDIR}/git"

# Specify dependencies if any
RDEPENDS:${PN} = "python3 python3-pyyaml pip-paho-mqtt pip-asyncio pip-dotmap pip-pyaml-env pip-tellcore-py"

inherit python3-dir systemd

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "telldus-core-mqtt.service"

SRC_URI += "file://telldus-core-mqtt.service"
FILES:${PN} += "${systemd_unitdir}/system/telldus-core-mqtt.service"

INSANE_SKIP:${PN} += "dev-deps"

# Define where to install the files
do_install() {
    install -d ${D}${datadir}/telldus-core-mqtt
    cp -r ${S}/* ${D}${datadir}/telldus-core-mqtt/

    # Optionally create a script to run the main file
    install -d ${D}${bindir}
    echo '#!/bin/sh' > ${D}${bindir}/telldus-core-mqtt
    echo 'python3 ${datadir}/telldus-core-mqtt/telldus-core-mqtt.py "$@"' >> ${D}${bindir}/telldus-core-mqtt
    chmod +x ${D}${bindir}/telldus-core-mqtt

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/telldus-core-mqtt.service ${D}${systemd_unitdir}/system/
}

# FILES_${PN} specifies what files should be packaged
FILES:${PN} += "${datadir}/telldus-core-mqtt"
FILES:${PN} += "${bindir}/telldus-core-mqtt"
