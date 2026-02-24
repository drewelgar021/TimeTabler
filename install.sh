#!/bin/bash

APP_NAME="timetabler"
INSTALL_DIR="$HOME/.local/bin"

echo "Installing $APP_NAME..."

mkdir -p "$INSTALL_DIR"

# Create symlink instead of copying
ln -sf "$(pwd)/$APP_NAME" "$INSTALL_DIR/$APP_NAME"

echo "Installation complete."
