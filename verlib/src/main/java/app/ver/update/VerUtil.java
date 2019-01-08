package app.ver.update;

import android.app.Activity;

public class VerUtil {

    private Activity context;

//    final OkHttpClient client = new OkHttpClient();
    String sp_name = "versionInfoSave";
    String versionSaveKey = "versionSaveKey";

    public VerUtil(Activity activity){
        context = activity;
    }

    /**
     * 判断是否版本更新
     **/
//    public void verCheck(String version, String app_type) {
//
//        RequestBody formBody = new FormBody.Builder()
//                .add("os_type", "android")
//                .add("app_type", app_type)
//                .add("version", version)
//                .build();
//
//        final Request request = new Request.Builder()
//                .url("http://api3.fc.xishisoft.com/sites/versionCheck")
//                .post(formBody)
//                .build();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Response response = null;
//                try {
//                    response = client.newCall(request).execute();
//                    if (response.isSuccessful()) {
//                        String responseBody = response.body().string();
//
//                        Log.i("WY", "打印POST响应的数据：" + responseBody);
//
//                        try {
//                            Gson gson = new GsonBuilder().create();
//                            final VersionCheck versionInfo = gson.fromJson(responseBody, VersionCheck.class);
//
//                            context.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    judgeVersionInfo(versionInfo);
//                                }
//                            });
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    } else {
//                        throw new IOException("Unexpected code " + response);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//    }
//
//    private void judgeVersionInfo(final VersionCheck info) {
//
//        // code == 1 返回结果为1 表示成功
//        if (info.getCode() != 1) {
//            return;
//        }
//
//        // 1. 判断是否忽略更新
//        //获得SharedPreferences的实例
//        SharedPreferences sp = context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
//        //通过key值获取到相应的data，如果没取到，则返回后面的默认值
//        String data = sp.getString(versionSaveKey, "0");
//        if (data.equalsIgnoreCase(info.getData().getVersion())) {
//            return;
//        }
//
//        // 2. 更新弹窗
//        if (info.getData().getUpdate_flag() == 1) { // 建议更新
//
//            final YCAlertDialog alertDialog = new YCAlertDialog(context).builder().setCancelable(false);
//            alertDialog.setTitle(info.getData().getTittle()).setMsg(info.getData().getMemo())
//                    .setNegativeButton("忽略更新", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            //获得SharedPreferences的实例 sp_name是文件名
//                            SharedPreferences sp = context.getSharedPreferences(sp_name, Context.MODE_PRIVATE);
//                            //获得Editor 实例
//                            SharedPreferences.Editor editor = sp.edit();
//                            //以key-value形式保存数据
//                            editor.putString(versionSaveKey, info.getData().getVersion());
//                            //apply()是异步写入数据
//                            editor.apply();
//                            //commit()是同步写入数据
//                            //editor.commit();
//                        }
//                    })
//                    .setPositiveButton("立即更新", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Uri uri = Uri.parse(info.getData().getUrl());
//                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                            context.startActivity(intent);
//                            alertDialog.dissmiss();
//
//                        }
//                    }).show();
//        } else if (info.getData().getUpdate_flag() == 2) { // 强制更新
//
//            final YCAlertDialog alertDialog = new YCAlertDialog(context).builder().setCancelable(false);
//            alertDialog.setTitle(info.getData().getTittle()).setMsg(info.getData().getMemo())
//                    .setPositiveButton("立即更新", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Uri uri = Uri.parse(info.getData().getUrl());
//                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                            context.startActivity(intent);
//                            context.finish();
//                        }
//                    }).show();
//        }
//    }

}
