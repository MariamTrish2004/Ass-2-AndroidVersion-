package com.example.android_virsion;

public class AndroidVersion {
        private int imageResId;
        private String codeName;
        private String version;

        public AndroidVersion(int imageResId, String codeName, String version) {
            this.imageResId = imageResId;
            this.codeName = codeName;
            this.version = version;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getCodeName() {
            return codeName;
        }

        public String getVersion() {
            return version;
        }
}
