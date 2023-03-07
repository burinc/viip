#!/usr/bin/env bash
set -eo pipefail
# Script to build the tools locally
bb clean
bb build
bb native-image-uber
# If things goes as plan then you can
# Name it properly for public usage
mkdir -p ~/bin # just in case
\cp ./target/viip ~/bin/viip
