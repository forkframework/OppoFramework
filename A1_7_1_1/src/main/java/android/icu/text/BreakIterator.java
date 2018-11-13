package android.icu.text;

import android.icu.util.ICUCloneNotSupportedException;
import android.icu.util.ULocale;
import android.icu.util.ULocale.Type;
import java.lang.ref.SoftReference;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Locale;
import java.util.MissingResourceException;

/*  JADX ERROR: NullPointerException in pass: ReSugarCode
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ReSugarCode.initClsEnumMap(ReSugarCode.java:159)
    	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.ExtractFieldInit.checkStaticFieldsInit(ExtractFieldInit.java:58)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:44)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:12)
    	at jadx.core.ProcessClass.process(ProcessClass.java:32)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
    	at java.lang.Iterable.forEach(Iterable.java:75)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
    	at jadx.core.ProcessClass.process(ProcessClass.java:37)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
    */
public abstract class BreakIterator implements Cloneable {
    private static final boolean DEBUG = false;
    public static final int DONE = -1;
    public static final int KIND_CHARACTER = 0;
    private static final int KIND_COUNT = 5;
    public static final int KIND_LINE = 2;
    public static final int KIND_SENTENCE = 3;
    public static final int KIND_TITLE = 4;
    public static final int KIND_WORD = 1;
    public static final int WORD_IDEO = 400;
    public static final int WORD_IDEO_LIMIT = 500;
    public static final int WORD_KANA = 300;
    public static final int WORD_KANA_LIMIT = 400;
    public static final int WORD_LETTER = 200;
    public static final int WORD_LETTER_LIMIT = 300;
    public static final int WORD_NONE = 0;
    public static final int WORD_NONE_LIMIT = 100;
    public static final int WORD_NUMBER = 100;
    public static final int WORD_NUMBER_LIMIT = 200;
    private static final SoftReference<?>[] iterCache = null;
    private static BreakIteratorServiceShim shim;
    private ULocale actualLocale;
    private ULocale validLocale;

    private static final class BreakIteratorCache {
        private BreakIterator iter;
        private ULocale where;

        BreakIteratorCache(ULocale where, BreakIterator iter) {
            this.where = where;
            this.iter = (BreakIterator) iter.clone();
        }

        ULocale getLocale() {
            return this.where;
        }

        BreakIterator createBreakInstance() {
            return (BreakIterator) this.iter.clone();
        }
    }

    static abstract class BreakIteratorServiceShim {
        public abstract BreakIterator createBreakIterator(ULocale uLocale, int i);

        public abstract Locale[] getAvailableLocales();

        public abstract ULocale[] getAvailableULocales();

        public abstract Object registerInstance(BreakIterator breakIterator, ULocale uLocale, int i);

        public abstract boolean unregister(Object obj);

        BreakIteratorServiceShim() {
        }
    }

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: android.icu.text.BreakIterator.<clinit>():void, dex: 
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:118)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:248)
        	at jadx.core.ProcessClass.process(ProcessClass.java:29)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
        	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
        	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:581)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:74)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:104)
        	... 9 more
        */
    static {
        /*
        // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: android.icu.text.BreakIterator.<clinit>():void, dex: 
        */
        throw new UnsupportedOperationException("Method not decompiled: android.icu.text.BreakIterator.<clinit>():void");
    }

    public abstract int current();

    public abstract int first();

    public abstract int following(int i);

    public abstract CharacterIterator getText();

    public abstract int last();

    public abstract int next();

    public abstract int next(int i);

    public abstract int previous();

    public abstract void setText(CharacterIterator characterIterator);

    protected BreakIterator() {
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (Throwable e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public int preceding(int offset) {
        int pos = following(offset);
        while (pos >= offset && pos != -1) {
            pos = previous();
        }
        return pos;
    }

    public boolean isBoundary(int offset) {
        boolean z = true;
        if (offset == 0) {
            return true;
        }
        if (following(offset - 1) != offset) {
            z = false;
        }
        return z;
    }

    public int getRuleStatus() {
        return 0;
    }

    public int getRuleStatusVec(int[] fillInArray) {
        if (fillInArray != null && fillInArray.length > 0) {
            fillInArray[0] = 0;
        }
        return 1;
    }

    public void setText(String newText) {
        setText(new StringCharacterIterator(newText));
    }

    public static BreakIterator getWordInstance() {
        return getWordInstance(ULocale.getDefault());
    }

    public static BreakIterator getWordInstance(Locale where) {
        return getBreakInstance(ULocale.forLocale(where), 1);
    }

    public static BreakIterator getWordInstance(ULocale where) {
        return getBreakInstance(where, 1);
    }

    public static BreakIterator getLineInstance() {
        return getLineInstance(ULocale.getDefault());
    }

    public static BreakIterator getLineInstance(Locale where) {
        return getBreakInstance(ULocale.forLocale(where), 2);
    }

    public static BreakIterator getLineInstance(ULocale where) {
        return getBreakInstance(where, 2);
    }

    public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(ULocale.getDefault());
    }

    public static BreakIterator getCharacterInstance(Locale where) {
        return getBreakInstance(ULocale.forLocale(where), 0);
    }

    public static BreakIterator getCharacterInstance(ULocale where) {
        return getBreakInstance(where, 0);
    }

    public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(ULocale.getDefault());
    }

    public static BreakIterator getSentenceInstance(Locale where) {
        return getBreakInstance(ULocale.forLocale(where), 3);
    }

    public static BreakIterator getSentenceInstance(ULocale where) {
        return getBreakInstance(where, 3);
    }

    public static BreakIterator getTitleInstance() {
        return getTitleInstance(ULocale.getDefault());
    }

    public static BreakIterator getTitleInstance(Locale where) {
        return getBreakInstance(ULocale.forLocale(where), 4);
    }

    public static BreakIterator getTitleInstance(ULocale where) {
        return getBreakInstance(where, 4);
    }

    public static Object registerInstance(BreakIterator iter, Locale locale, int kind) {
        return registerInstance(iter, ULocale.forLocale(locale), kind);
    }

    public static Object registerInstance(BreakIterator iter, ULocale locale, int kind) {
        if (iterCache[kind] != null) {
            BreakIteratorCache cache = (BreakIteratorCache) iterCache[kind].get();
            if (cache != null && cache.getLocale().equals(locale)) {
                iterCache[kind] = null;
            }
        }
        return getShim().registerInstance(iter, locale, kind);
    }

    public static boolean unregister(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("registry key must not be null");
        } else if (shim == null) {
            return false;
        } else {
            for (int kind = 0; kind < 5; kind++) {
                iterCache[kind] = null;
            }
            return shim.unregister(key);
        }
    }

    @Deprecated
    public static BreakIterator getBreakInstance(ULocale where, int kind) {
        if (where == null) {
            throw new NullPointerException("Specified locale is null");
        }
        if (iterCache[kind] != null) {
            BreakIteratorCache cache = (BreakIteratorCache) iterCache[kind].get();
            if (cache != null && cache.getLocale().equals(where)) {
                return cache.createBreakInstance();
            }
        }
        BreakIterator result = getShim().createBreakIterator(where, kind);
        iterCache[kind] = new SoftReference(new BreakIteratorCache(where, result));
        if (result instanceof RuleBasedBreakIterator) {
            ((RuleBasedBreakIterator) result).setBreakType(kind);
        }
        return result;
    }

    public static synchronized Locale[] getAvailableLocales() {
        Locale[] availableLocales;
        synchronized (BreakIterator.class) {
            availableLocales = getShim().getAvailableLocales();
        }
        return availableLocales;
    }

    public static synchronized ULocale[] getAvailableULocales() {
        ULocale[] availableULocales;
        synchronized (BreakIterator.class) {
            availableULocales = getShim().getAvailableULocales();
        }
        return availableULocales;
    }

    private static BreakIteratorServiceShim getShim() {
        if (shim == null) {
            try {
                shim = (BreakIteratorServiceShim) Class.forName("android.icu.text.BreakIteratorFactory").newInstance();
            } catch (MissingResourceException e) {
                throw e;
            } catch (Exception e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                throw new RuntimeException(e2.getMessage());
            }
        }
        return shim;
    }

    public final ULocale getLocale(Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    final void setLocale(ULocale valid, ULocale actual) {
        Object obj;
        Object obj2 = 1;
        if (valid == null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (actual != null) {
            obj2 = null;
        }
        if (obj != obj2) {
            throw new IllegalArgumentException();
        }
        this.validLocale = valid;
        this.actualLocale = actual;
    }
}