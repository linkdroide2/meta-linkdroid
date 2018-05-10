SUMMARY = "gstreamer subsink plugin"
SECTION = "multimedia"
PRIORITY = "optional"
DEPENDS = "gstreamer gst-plugins-base"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"


PV = "0.10.1"
PR = "r3"

SRC_URI = "file://gst-plugin-subsink.zip"

S = "${WORKDIR}/gst-plugin-subsink"

GSTVERSION = "0.10"

EXTRA_OECONF = "--with-gstversion=${GSTVERSION}"

DEPENDS = "glib-2.0-native gstreamer"


inherit autotools pkgconfig
do_configure_prepend() {
        sed -i 's/AC_INIT.*$/AC_INIT(gst-plugin-subsink, 0.10.0, @pli4)/' ${S}/configure.ac
        sed -i 's/AM_INIT_AUTOMAKE.*$/AM_INIT_AUTOMAKE([foreign subdir-objects])/' ${S}/configure.ac
}


FILES_${PN} = "${libdir}/gstreamer-0.10/*.so*"
FILES_${PN}-dev += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-0.10/*.a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

PACKAGE_ARCH = "${MACHINE_ARCH}"
