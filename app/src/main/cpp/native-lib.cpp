#include <string.h>
#include <jni.h>

extern "C" JNIEXPORT jstring
JNICALL Java_id_ac_ui_cs_mobileprogramming_azharaiz_labs_MainActivity_helloFromJNI(
        JNIEnv* env, jobject, jstring inputName) {
    const char *name = env -> GetStringUTFChars(inputName, NULL);
    char message[60] = "Hello ";

    strcat(message, name);

    env -> ReleaseStringUTFChars(inputName, name);
    return env->NewStringUTF(message);
}