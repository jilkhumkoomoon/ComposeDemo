package com.moon.composedemo.coroutine;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;


public class CoroutineScene2_decompiled {

    public static final Object request2(Continuation preCallback) {

        ContinuationImpl request2Callback;

        request2Callback = new ContinuationImpl(preCallback) {

            @Override
            Object invokeSuspend(@NotNull Object reusmeResult) {
                return null;
            }
        };

        if(!(preCallback instanceof ContinuationImpl)) {

        }

        return request2Callback;

    }


    static abstract class ContinuationImpl<T> implements Continuation <T> {
        private Continuation preCallback;

        public ContinuationImpl(Continuation preCallback) {
            this.preCallback = preCallback;
        }


        @NonNull
        @Override
        public CoroutineContext getContext() {
            return preCallback.getContext();
        }

        @Override
        public void resumeWith(@NonNull Object o) {

        }

        abstract Object invokeSuspend(@NotNull Object reusmeResult);
    }

}
