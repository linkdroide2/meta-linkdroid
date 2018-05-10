MAINTAINER = "PurE2"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_openatv = "r47-A5atv"
PR_openvix = "r48-A5vix"
PR_pure2 = "r47-A5pure2"


SRC_URI_append_openatv = " \
    file://configure.ac \
    file://AVSwitch.py \
    file://Lcd.py \
    file://amldecoder.* \
    file://atv-actions64-bit.patch \
    file://servicemp3.cpp \
    file://frontend.cpp \
    "

do_configure_prepend_openatv() {
    cp -f ${WORKDIR}/configure.ac  ${S}/
    cp -f ${WORKDIR}/AVSwitch.py  ${S}/lib/python/Components/
    cp -f ${WORKDIR}/Lcd.py  ${S}/lib/python/Components/
    cp -f ${WORKDIR}/frontend.cpp  ${S}/lib/dvb/
    cp -f ${WORKDIR}/servicemp3.cpp  ${S}/lib/service/
    cp -f ${WORKDIR}/amldecoder.cpp  ${S}/lib/dvb/
}



###################### ViX #######################################################

SRC_URI_openvix = "git://github.com/OpenViX/enigma2.git;protocol=git;branch=amlogic"

SRC_URI_append_openvix = " \
     \
    file://enigma2.sh.in \
    file://configure.ac \
    file://About.py \
    file://action.h \
    file://action.cpp \
     \
    "


do_configure_prepend_openvix() {
    cp -f ${WORKDIR}/configure.ac  ${S}/
    cp -f ${WORKDIR}/action.cpp  ${S}/lib/actions/
    cp -f ${WORKDIR}/action.h  ${S}/lib/actions/
    cp -f ${WORKDIR}/About.py  ${S}/lib/python/Screens/
}


