SSUMMARY = "Amlogic audio video utils library"
PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r3"

inherit lib_package


SRC_URI = "file://avplayer/media/amavutils/include/* \
			file://libamavutils.so \
"
S = "${WORKDIR}/avplayer/media/amavutils"



do_install() {
    install -d ${D}${includedir}
    install -d ${D}${libdir}
    cp -PR ${S}/include ${D}/usr
    install -m 0755 ${WORKDIR}/libamavutils.so ${D}/${libdir}
}

FILES_${PN} = "${includedir}/* ${libdir}/* "
FILES_${PN}-dev = "/usr/include/*"
FILES_${PN}-src = ""
