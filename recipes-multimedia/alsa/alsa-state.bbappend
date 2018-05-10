FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR = "r99a"

SRC_URI += "\
  file://asound.conf \
  file://asound.state \
  file://alsa-state-init \
  file://SOC-Audio.conf  \
  file://AML-M8AUDIO.conf  \
"

do_install_append() {

### TODO! probably more decent path is "/usr/share/alsa/alsa.conf.d" check later...

   install -d ${D}${datadir}/alsa/cards
   install -m 0644 ${WORKDIR}/SOC-Audio.conf  ${D}${datadir}/alsa/cards
   install -m 0644 ${WORKDIR}/AML-M8AUDIO.conf  ${D}${datadir}/alsa/cards

}

FILES_${PN}_append = " ${datadir}/alsa/cards/* "
