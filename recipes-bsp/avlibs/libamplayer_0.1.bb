SUMMARY = "Amlogic player library"
PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

DEPENDS = "libamadec libamcodec"
RDEPENDS_${PN} = "libamadec libamcodec"

inherit lib_package


SRC_URI = "file://avplayer/LibPlayer/amplayer/player/include/* \
           file://libamplayer.pc \
	   file://libamplayer.so \
"

S = "${WORKDIR}/avplayer/LibPlayer/amplayer/player"

EXTRA_OEMAKE = "\
    'CC=${CC}' \
    'LD=${LD}' \
    'CFLAGS=-fPIC -DENABLE_FREE_SCALE -I${S}/include -I${S}/../../amffmpeg -I${S}/player/ -I${S}/../../../media/amcodec/include -I${S}/../../../media/amcodec/codec \
    -I${S}/player/include -I${S} -I${STAGING_INCDIR}/amlogic/amcodec -I${S}/../../../LibAudio/amadec/include -I${S}/../../../media/amavutils/include' \
    'LDFLAGS=-lamadec -lm -lc  -shared -Wl,--shared ' \
"

do_install() {
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${WORKDIR}/libamplayer.pc ${D}${libdir}/pkgconfig/
    install -d ${D}${includedir}/amlogic/player
    install -d ${D}${libdir}
    install -m 0755  ${WORKDIR}/libamplayer.so  ${D}${libdir}
    cp -pR  ${S}/include/* ${D}${includedir}/amlogic/player
}

FILES_${PN} = "${libdir}/* "
FILES_${PN}-dev = "${includedir}/*"
