package myinterface;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

@ThriftService
public interface MyService {
  @ThriftMethod
  String getName();
}
