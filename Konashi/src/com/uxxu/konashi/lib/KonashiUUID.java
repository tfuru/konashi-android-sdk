package com.uxxu.konashi.lib;

import java.util.UUID;

/**
 * konashiで使用するGATTのUUID
 * 
 * @author monakaz, YUKAI Engineering
 * http://konashi.ux-xu.com
 * ========================================================================
 * Copyright 2014 Yukai Engineering Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
/**
 * konashi2で使用するGATTのUUIDに書き換え
 * @author t_furu
 * 
 */
public class KonashiUUID {

	// Battery service UUID
    public static final UUID BATTERY_SERVICE_UUID                     = UUID.fromString("0000180F-0000-1000-8000-00805F9B34FB");
    public static final UUID BATTERY_LEVEL_UUID                       = UUID.fromString("00002A19-0000-1000-8000-00805F9B34FB");
    //public static final UUID POWER_STATE_UUID     = UUID.fromString("00002A1B-0000-1000-8000-00805F9B34FB");
    
    // konashi service UUID
    public static final UUID KONASHI_SERVICE_UUID                     = UUID.fromString("229BFF00-03FB-40DA-98A7-B0DEF65C2D4B");

    // PIO characteristics
    public static final UUID PIO_SETTING_UUID                         = UUID.fromString("229B3000-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID PIO_PULLUP_UUID                          = UUID.fromString("229B3001-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID PIO_OUTPUT_UUID                          = UUID.fromString("229B3002-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID PIO_INPUT_NOTIFICATION_UUID              = UUID.fromString("229B3003-03FB-40DA-98A7-B0DEF65C2D4B");
    
    // PWM characteristics    
    public static final UUID PWM_CONFIG_UUID                          = UUID.fromString("229B3004-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID PWM_PARAM_UUID                           = UUID.fromString("229B3005-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID PWM_DUTY_UUID                            = UUID.fromString("229B3006-03FB-40DA-98A7-B0DEF65C2D4B");

    // Analog characteristics  
    public static final UUID ANALOG_DRIVE_UUID                        = UUID.fromString("229B3007-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID ANALOG_READ0_UUID                        = UUID.fromString("229B3008-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID ANALOG_READ1_UUID                        = UUID.fromString("229B3009-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID ANALOG_READ2_UUID                        = UUID.fromString("229B300A-03FB-40DA-98A7-B0DEF65C2D4B");

    // I2C characteristics
    public static final UUID I2C_CONFIG_UUID                          = UUID.fromString("229B300B-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID I2C_START_STOP_UUID                      = UUID.fromString("229B300C-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID I2C_WRITE_UUID                           = UUID.fromString("229B300D-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID I2C_READ_PARAM_UUID                      = UUID.fromString("229B300E-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID I2C_READ_UUID                            = UUID.fromString("229B300F-03FB-40DA-98A7-B0DEF65C2D4B");

    // UART characteristics    
    public static final UUID UART_CONFIG_UUID                         = UUID.fromString("229B3010-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID UART_BAUDRATE_UUID                       = UUID.fromString("229B3011-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID UART_TX_UUID                             = UUID.fromString("229B3012-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID UART_RX_NOTIFICATION_UUID                = UUID.fromString("229B3013-03FB-40DA-98A7-B0DEF65C2D4B");

    // Hardware characteristics
    public static final UUID HARDWARE_RESET_UUID                      = UUID.fromString("229B3014-03FB-40DA-98A7-B0DEF65C2D4B");
    public static final UUID HARDWARE_LOW_BAT_NOTIFICATION_UUID       = UUID.fromString("229B3015-03FB-40DA-98A7-B0DEF65C2D4B");

    // DFU service characteristics
    public static final UUID UPGRADE_SERVICE_UUID                     = UUID.fromString("3908d54f-0c55-4ea1-8fd1-8394a172257d");
    public static final UUID UPGRADE_CHARACTERISTIC_CONTROL_POINT_UUID= UUID.fromString("0f7a29bb-a965-4279-8546-b56e981c008b");
    public static final UUID UPGRADE_CHARACTERISTIC_DATA_UUID         = UUID.fromString("8e922cce-eec6-47b0-b46d-09563a8da638");

    // characteristic configuration characteristics
    public static final UUID CLIENT_CHARACTERISTIC_CONFIG             = UUID.fromString("00002902-0000-1000-8000-00805F9B34FB");
}
