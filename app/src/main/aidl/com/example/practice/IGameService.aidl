package com.example.practice;

import com.example.practice.IRequestCallback;

// رابط اصلی برای ارائه سرویس به اپلیکیشن Gapgram
interface IGameService {
   void newMatch(String params);  // متدی برای ایجاد مسابقه جدید
   void canAcceptMatch(String params, IRequestCallback callback);  // متدی که نیاز به یک callback دارد
   void startApp(String params);  // متدی برای شروع یک اپلیکیشن
}
