package net.skaidream.SkaiDreamCore.store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.stream.JsonReader;

import net.skaidream.SkaiDreamCore.json.JSONArray;
import net.skaidream.SkaiDreamCore.json.JSONObject;

public class SDColl
{
	public static void main(String[] args)
	{
        //���� �ϼ��� JSONObject ����(��ü)
        JSONObject jsonObject = new JSONObject();
        //person�� JSON������ ���� Array ����
        JSONArray personArray = new JSONArray();
        //person�� �Ѹ� ������ �� JSONObject ����
        JSONObject personInfo = new JSONObject();
        //���� �Է�
        personInfo.put("name", "�۰�ȣ");
        personInfo.put("age", "25");
        personInfo.put("gender", "����");
        personInfo.put("nickname", "���ùμ�");
        //Array�� �Է�
        personArray.put(personInfo);
 
        personInfo = new JSONObject();
        personInfo.put("name", "������");
        personInfo.put("age", "21");
        personInfo.put("gender", "����");
        personInfo.put("nickname", "������");
        personArray.put(personInfo);
        //��ü�� JSONObject�� ����̶� name���� JSON�� ������ ������ Array�� value�� �Է�
        jsonObject.put("persons", personArray);
 
         
        JSONArray bookArray = new JSONArray();
 
        JSONObject bookInfo = new JSONObject();
        bookInfo.put("name", "����� �������� ��°�?");
        bookInfo.put("writer", "�罺����");
        bookInfo.put("price", "100");
        bookInfo.put("genre", "�Ҽ�");
        bookInfo.put("publisher", "�罺���� ���ǻ�");
        bookArray.put(bookInfo);
 
        bookInfo = new JSONObject();
        bookInfo.put("name", "ȫ�浿��");
        bookInfo.put("writer", "���");
        bookInfo.put("price", "300");
        bookInfo.put("genre", "�Ҽ�");
        bookInfo.put("publisher", "��� ���ǻ�");
        bookArray.put(bookInfo);
 
        bookInfo = new JSONObject();
        bookInfo.put("name", "���������");
        bookInfo.put("writer", "���丣 ����");
        bookInfo.put("price", "900");
        bookInfo.put("genre", "�Ҽ�");
        bookInfo.put("publisher", "���丣 ���� ���ǻ�");
        bookArray.put(bookInfo);
 
        jsonObject.put("books", bookArray);
 
        //JSONObject�� String ��ü�� �Ҵ�
        String jsonInfo = jsonObject.toString(4);
 
        System.out.print(jsonInfo);
        try
        {
        	FileWriter file = new FileWriter("C:\\Users\\Junwon\\Desktop\\tests.json");
        	file.write(jsonInfo);
        	file.flush();
        	file.close();
        }
        catch(IOException e)
        {
        	e.printStackTrace();
        }
        
	}
}
