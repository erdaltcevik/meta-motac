SUMMARY = "MOTAC Development filesystem image"
DESCRIPTION = "Development filesystem image for mota-on-CM4"
LICENSE = "MIT"
export IMAGE_BASENAME = "img-motac"

inherit core-image populate_sdk

IMAGE_FSTYPES:remove = " ext3 "
IMAGE_FSTYPES:append = " wic "

IMAGE_INSTALL += " \
   packagegroup-motac \
"

##IMAGE_LINGUAS:remove = " en-gb "

BAD_RECOMMENDATIONS:pn-${PN} += " \
  init-ifupdown \
"
##  udev-hwdb \
##  adwaita-icon-theme-symbolic \
##  ifupdown \
##  
##
##
##
##

##PACKAGECONFIG:append:pn-avahi = " \
## \
##"

##SDK_TOOLCHAIN_LANGS:append = "rust"

inherit extrausers

# Password: "erdal"
# printf "%q" $(mkpasswd -m sha256crypt erdal)
PASSWD = "\$5\$Tklv72xH8CmdNdaI\$pf7A2jR/s1eokny1KP0fsGQNz4LIvy2UukZ/ndi4bn2"
EXTRA_USERS_PARAMS = " \
  useradd -p '${PASSWD}' -u 1000 -G input,video,wayland,render  erdal; \
  "


