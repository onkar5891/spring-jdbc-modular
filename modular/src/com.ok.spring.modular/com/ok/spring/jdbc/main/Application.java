package com.ok.spring.jdbc.main;

import java.io.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import com.ok.spring.jdbc.config.AppConfig;
import com.ok.spring.jdbc.dao.KeyValDaoTemplate;

import com.ok.spring.jdbc.entity.KeyVal;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		KeyValDaoTemplate kvDao = context.getBean(KeyValDaoTemplate.class);

		try {
			System.out.println("Loaded context: " + context);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				System.out.print("1. Insert a KV\n2. Get K\n3. Exit\nOption? ");
				int opt;
				try {
					opt = Integer.parseInt(br.readLine());
					switch(opt) {
						case 1:
							System.out.println("Enter {key: value} pair -");
							String key = br.readLine();
							String value = br.readLine();
							kvDao.save(new KeyVal(key, value));
							break;
						case 2:
							System.out.println("Enter key -");
							String keyG = br.readLine();
							String valueG = kvDao.findByKey(keyG);
							if(valueG != null) {
								System.out.println(new KeyVal(keyG, valueG));
							}
							break;
						case 3:
							System.exit(0);
						default: 
							System.out.println("Invalid option");
					}
				} catch(NumberFormatException e) {
					System.out.println("Invalid option");
				}
			}
		} catch(IOException e) {
			System.out.println("IO Error: " + e.getMessage());
		}
	}
}

