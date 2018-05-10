require conf/license/license-gplv2.inc

PV = "1.0"
PR = "r2"

SRC_URI = " file://a5-shutdown.sh \
            file://a-shutdown.sh \
"

S = "${WORKDIR}"

INITSCRIPT_NAME = "a5-shutdown"
INITSCRIPT_PARAMS = "start 39 0 ."

inherit pkgconfig update-rc.d

do_install() {
    install -d ${D}/etc/init.d/
    if [ "${MACHINE}" = "alien5" ]; then
        install -m 0755 ${WORKDIR}/a5-shutdown.sh ${D}/etc/init.d/a5-shutdown
    else
        install -m 0755 ${WORKDIR}/a-shutdown.sh ${D}/etc/init.d/a-shutdown
    fi
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
