#include <jni.h>

extern "C"
JNIEXPORT jint

JNICALL
Java_com_tck_jnidemo_jnicalculator_JniCalculatorUtils_plus(JNIEnv *env, jclass type, jint a,
                                                           jint b) {

    return a + b;

}