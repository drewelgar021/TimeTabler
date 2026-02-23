#!/bin/bash

APP_NAME="timetabler"
INSTALL_DIR="$HOME/.local/bin"
SHELL_CONFIG="$HOME/.bashrc"

echo "Installing $APP_NAME..."

mkdir -p "$INSTALL_DIR"

# Copy launcher
cp "$APP_NAME" "$INSTALL_DIR/"
chmod +x "$INSTALL_DIR/$APP_NAME"

# Add to PATH if not already there
if ! echo "$PATH" | grep -q "$INSTALL_DIR"; then
    echo "export PATH=\"$INSTALL_DIR:\$PATH\"" >> "$SHELL_CONFIG"
fi

echo "Installation complete."
echo "Restart your terminal or run:"
echo "source $SHELL_CONFIG"