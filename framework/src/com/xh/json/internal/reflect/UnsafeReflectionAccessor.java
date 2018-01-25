/*
 * Copyright (C) 2017 The Gson authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xh.json.internal.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

import com.xh.reflect.MethodManager;

/**
 * An implementation of {@link ReflectionAccessor} based on {@link Unsafe}.
 * <p>
 * NOTE: This implementation is designed for Java 9. Although it should work
 * with earlier Java releases, it is better to use
 * {@link PreJava9ReflectionAccessor} for them.
 */
final class UnsafeReflectionAccessor extends ReflectionAccessor {

	private final Object theUnsafe = getUnsafeInstance();
	private final Field overrideField = getOverrideField();
	private static Class cl;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void makeAccessible(AccessibleObject ao) {
		if (theUnsafe != null && overrideField != null && cl != null) {
			long overrideOffset =(long) MethodManager.invoke(MethodManager.method(cl, "objectFieldOffset",
					new Class[]{Field.class}), theUnsafe, new Object[] { overrideField });
			MethodManager.invoke(MethodManager.method(cl, "putBoolean", new Class[]{ao.getClass(),Field.class,boolean.class}), theUnsafe, new Object[]{ao, overrideOffset, true});
		}
	}

	private static Object getUnsafeInstance() {
		try {
			cl = Class.forName("sun.misc.Unsafe");
			Field unsafeField = cl.getDeclaredField("theUnsafe");
			unsafeField.setAccessible(true);
			return unsafeField.get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Field getOverrideField() {
		try {
			return AccessibleObject.class.getDeclaredField("override");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
			return null;
		}
	}
}
