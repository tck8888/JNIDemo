#include <jni.h>
#include <string>
#include <android/log.h>
#include "md5.h"

using namespace std;

static const char *SALT = "yys";

extern "C" {
JNIEXPORT jstring JNICALL
Java_com_tck_jnidemo_jniencryption_JniEncryptionUtils_encryption(JNIEnv *env, jclass type,
                                                                 jstring content_);
}

JNIEXPORT jstring JNICALL
Java_com_tck_jnidemo_jniencryption_JniEncryptionUtils_encryption(JNIEnv *env, jclass type,
                                                                 jstring params_) {
    const char *params = env->GetStringUTFChars(params_, 0);

    string signature_str(params);
    signature_str.insert(0, SALT);

    MD5_CTX *ctx = new MD5_CTX();
    MD5Init(ctx);
    unsigned char *data = (unsigned char *)signature_str.c_str();
    MD5Update(ctx, data, signature_str.length());
    unsigned char digest[16] = {0};
    MD5Final(digest, ctx);

    // 生成 32 位的字符串
    char md5_str[32];
    for (int i = 0; i < 16; i++) {
        // 不足的情况下补0 f = 0f, ab = ab
        sprintf(md5_str, "%s%02x", md5_str, digest[i]);
    }
    env->ReleaseStringUTFChars(params_, params);
    return env->NewStringUTF(md5_str);
}