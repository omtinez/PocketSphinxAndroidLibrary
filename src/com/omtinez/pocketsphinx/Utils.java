package com.omtinez.pocketsphinx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.AssetManager;

public class Utils {
	
	public static void copyAsset(AssetManager assetManager, String assetName, String filePath) {
		
		// if the file already exists, nothing to do here
		File assetFile = new File(filePath);
		if (assetFile.exists()) return;
		
		// make sure that the parent directories exist
		File assetDir = new File(filePath.substring(0, filePath.lastIndexOf("/")));
		assetDir.mkdirs();
		
		// copy the file into the sd card
		InputStream in = null;
        OutputStream out = null;
        try {
			in = assetManager.open(assetName);
			out = new FileOutputStream(filePath);
			copyFile(in, out);
        } catch(IOException e) {
        	e.printStackTrace();
        }
	}

	private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
          out.write(buffer, 0, read);
        }
    }
	
	// Copy all the assets from the apk file to the sd card
	public static void copyAllAssets(Context context) {
		AssetManager assetManager = context.getAssets();
		copyAsset(assetManager, "lm/es_ES/Ohphone.jsgf", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/lm/es_ES/Ohphone.jsgf");
		copyAsset(assetManager, "lm/es_ES/Ohphone.dic", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/lm/es_ES/Ohphone.dic");
		copyAsset(assetManager, "hmm/es_ES/feat.params", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/feat.params");
		copyAsset(assetManager, "hmm/es_ES/mdef", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/mdef");
		copyAsset(assetManager, "hmm/es_ES/means", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/means");
		copyAsset(assetManager, "hmm/es_ES/noisedict", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/noisedict");
		copyAsset(assetManager, "hmm/es_ES/transition_matrices", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/transition_matrices");
		copyAsset(assetManager, "hmm/es_ES/variances", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/variances");
		copyAsset(assetManager, "hmm/es_ES/mixture_weights", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/mixture_weights");
		copyAsset(assetManager, "hmm/es_ES/feature_transform", 
				"/sdcard/Android/data/com.omtinez.pocketsphinx/hmm/es_ES/feature_transform");
	}

	// delete all the assets from the sd card
	public static void deleteAllAssets() {
		File masterFolder = new File("/sdcard/Android/data/com.omtinez.pocketsphinx/");
		delete(masterFolder);
	}
	
	private static void delete(File f) {
		if (f.isDirectory()) {
			for (File c : f.listFiles()) delete(c);
		} else {
			f.delete();
		}
	}
}