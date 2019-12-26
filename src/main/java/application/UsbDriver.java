package application;

import java.util.ArrayList;

import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbHub;

public class UsbDriver {

	public UsbDevice findDevice(UsbHub hub, short vendorId, short productId)
	{
	    for (UsbDevice device : (ArrayList<UsbDevice>) hub.getAttachedUsbDevices())
	    {
	        UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
	        if (desc.idVendor() == vendorId && desc.idProduct() == productId) return device;
	        if (device.isUsbHub())
	        {
	            device = findDevice((UsbHub) device, vendorId, productId);
	            if (device != null) return device;
	        }
	    }
	    return null;
	}
}
