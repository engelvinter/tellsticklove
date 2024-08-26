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

inherit python3-dir

# Define where to install the files
do_install() {
    install -d ${D}${datadir}/telldus-core-mqtt
    cp -r ${S}/* ${D}${datadir}/telldus-core-mqtt/

    # Optionally create a script to run the main file
    install -d ${D}${bindir}
    echo '#!/bin/sh' > ${D}${bindir}/telldus-core-mqtt
    echo 'python3 ${datadir}/telldus-core-mqtt/telldus-core-mqtt.py "$@"' >> ${D}${bindir}/telldus-core-mqtt
    chmod +x ${D}${bindir}/telldus-core-mqtt
}

# FILES_${PN} specifies what files should be packaged
FILES:${PN} += "${datadir}/telldus-core-mqtt"
FILES:${PN} += "${bindir}/telldus-core-mqtt"
