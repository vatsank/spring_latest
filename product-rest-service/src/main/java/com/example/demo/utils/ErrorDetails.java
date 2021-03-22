package com.example.demo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.entity.Item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ErrorDetails {

	
	LocalDateTime date;
	String message;
	String description;
	
	
}

