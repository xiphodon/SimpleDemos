package com.example.x25_recorder;

import java.io.File;
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.sip.SipAudioCall.Listener;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class RecorderService extends Service {

	private MediaRecorder recorder;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//�õ��绰������
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		//�����绰״̬
		//events������ PhoneStateListener ����ʲô����
		tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
	}
	
	class MyListener extends PhoneStateListener{
		
		//һ���绰״̬�ı䣬�˷�������
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			
			switch (state) {
			
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("����״̬");
				if(recorder != null){
					//¼��ֹͣ
					recorder.stop();
					//�ͷ���Դ
					recorder.release();
					recorder = null;
				}
				break;
				
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("����״̬");
				
				//��ʼ��¼����
				if(recorder == null){
					recorder = new MediaRecorder();
					//������Ƶ��Դ      ����Ϊ��˷�
					recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
					//���ñ������Ƶ�ļ��ı����ʽ          ����Ϊ3GP��ʽ
					recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					//���ñ������Ƶ�ļ���·��������
					File file = new File(Environment.getExternalStorageDirectory(),"record.3gp");
					String path = file.getAbsolutePath();
					System.out.println(path);
					recorder.setOutputFile(path);
					//������Ƶ����
					recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
					try {
						//׼������
						recorder.prepare();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				break;
				
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("ժ��״̬");
				//��ʼ¼��
				if(recorder != null){
					//��ʼ¼��
					recorder.start();
				}
				break;

			}
		}
	}
}
