import intro1 from '@/assets/image/AFC-intro-1.png'
import intro2 from '@/assets/image/AFC-intro-2.png'
import intro3 from '@/assets/image/AFC-intro-3.png'

export const chatData = [
  {
    is_self: 1,
    created_at: '2022-04-17',
    content: 'What is AFC?',
    id: 1,
    type: 1, // 文字
  },
  {
    is_self: 0,
    created_at: '2023-04-17',
    content: "AFC is a complex air-fuel control system released by Toyota. The whole system takes two input signals from the outside environment, PedalAngle and EngineSpeed, and outputs μ = |AF - AF_ref|/AF_ref, which is the deviation of the air-to-fuel ratio AF from a reference value AF_ref. By changing the PedalAngle and EngineSpeed, the fuel controller should adjust the intake gas rate to the cylinder to maintain optimal air-to-fuel ratio. The goal of this system is to control the deviation μ no more than a predefined threshold.",
    id: 2,
    type: 1, // 文字
  },
  {
    is_self: 0,
    created_at: '2023-04-17',
    content: intro3,
    id: 3,
    type: 2, // 图片
  },

  {
    is_self: 1,
    created_at: '2022-04-17',
    content: 'What is the evaluation metrics for AFC?',
    id: 4,
    type: 1, // 文字
  },
  {
    is_self: 0,
    created_at: '2023-04-17',
    content: "S1: Hard Safety, S2: Soft Safety, S3: Steady State, S4: Resilience",
    id: 5,
    type: 1, // 文字
  },
  {
    is_self: 0,
    created_at: '2023-04-17',
    content: intro1,
    id: 6,
    type: 2, // 图片
  },
  {
    is_self: 1,
    created_at: '2023-04-17',
    content: "Show me the Simulink model of AI-Enabled Abstract Fuel Control System.",
    id: 7,
    type: 1, // 文字
  },
  {
    is_self: 0,
    created_at: '2023-04-17',
    content: intro2,
    id: 8,
    type: 2, // 图片
  },



]
